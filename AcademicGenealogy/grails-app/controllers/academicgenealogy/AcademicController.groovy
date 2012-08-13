package academicgenealogy

import org.springframework.dao.DataIntegrityViolationException
import groovy.xml.MarkupBuilder
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_SUPER', 'ROLE_ADMIN'])
class AcademicController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	//inject instance of academic service
	def academicService
	
	//this method/view allows searching for academics and generating their academic genealogies
	def find() {
		def academic
		if (!params.name || !params.depth) {
			 (academic = null)
		} else {
			String lName = params.name.split(" ")[-1]
			academic = Academic.findByLastName(lName)
		}
		["data":academicService.generateTree(academic, params.int('depth'))]
	}
	
	//this method generates a list of possible names for use in autofill searchbox
	def autoSearch = {
		def byFname = Academic.findAllByFirstNameIlike("%${params.query}%")
		def byMname = Academic.findAllByMiddleNameIlike("%${params.query}%")
		def byLname = Academic.findAllByLastNameIlike("%${params.query}%")
		def aNames = byFname + byMname + byLname
		aNames = aNames.unique()
		render(contentType: "text/xml") {
			results() {
				aNames.each { currentA ->
					result() {
						name(currentA.toString())
					}
				}
			}
		}
	}

    def index() {
        redirect(action: "find", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [academicInstanceList: Academic.list(params), academicInstanceTotal: Academic.count()]
    }

    def create() {
        [academicInstance: new Academic(params)]
    }

    def save() {
        def academicInstance = new Academic(params)
        if (!academicInstance.save(flush: true)) {
            render(view: "create", model: [academicInstance: academicInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'academic.label', default: 'Academic'), academicInstance.id])
        redirect(action: "show", id: academicInstance.id)
    }

    def show() {
        def academicInstance = Academic.get(params.id)
        if (!academicInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'academic.label', default: 'Academic'), params.id])
            redirect(action: "list")
            return
        }

        [academicInstance: academicInstance]
    }

    def edit() {
        def academicInstance = Academic.get(params.id)
        if (!academicInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'academic.label', default: 'Academic'), params.id])
            redirect(action: "list")
            return
        }

        [academicInstance: academicInstance]
    }

    def update() {
        def academicInstance = Academic.get(params.id)
        if (!academicInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'academic.label', default: 'Academic'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (academicInstance.version > version) {
                academicInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'academic.label', default: 'Academic')] as Object[],
                          "Another user has updated this Academic while you were editing")
                render(view: "edit", model: [academicInstance: academicInstance])
                return
            }
        }

        academicInstance.properties = params

        if (!academicInstance.save(flush: true)) {
            render(view: "edit", model: [academicInstance: academicInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'academic.label', default: 'Academic'), academicInstance.id])
        redirect(action: "show", id: academicInstance.id)
    }

    def delete() {
        def academicInstance = Academic.get(params.id)
        if (!academicInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'academic.label', default: 'Academic'), params.id])
            redirect(action: "list")
            return
        }

        try {
            academicInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'academic.label', default: 'Academic'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'academic.label', default: 'Academic'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
