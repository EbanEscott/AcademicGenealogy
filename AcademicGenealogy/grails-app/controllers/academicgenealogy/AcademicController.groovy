package academicgenealogy

import org.springframework.dao.DataIntegrityViolationException

class AcademicController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [academicInstanceList: Academic.list(params), academicInstanceTotal: Academic.count()]
    }
	
	def find() {
	}
	
	def tree() {
		def academic
		!params.lastName ? (academic = null) : (academic = Academic.findByLastName(params.lastName))
		String htmlOutput = ""
		def academicList = [academic]
		def supervisesList = []
		if (academic != null) {
			for (int i = 0; i < params.int('depth'); i++) {
				htmlOutput += "<p>"
				for (person in academicList) {
					htmlOutput += '||| <a href="tree?lastName='
					htmlOutput += "${person.lastName}"
					htmlOutput += '&depth='
					htmlOutput += "${params.depth}"
					htmlOutput += '">'
					htmlOutput += "${person.firstName} ${person.lastName} </a> |||"
					supervisesList += person.supervises
				}
				htmlOutput += "</p>"
				academicList.clear()
				academicList += supervisesList
				supervisesList.clear()
			}
		} else {
			render("Unknown Surame")
		}
		render(htmlOutput)
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
