package academicgenealogy

import org.springframework.dao.DataIntegrityViolationException

class InstitutionController {
	
	static scaffold = Institution
	
	/*

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [institutionInstanceList: Institution.list(params), institutionInstanceTotal: Institution.count()]
    }

    def create() {
        [institutionInstance: new Institution(params)]
    }

    def save() {
        def institutionInstance = new Institution(params)
        if (!institutionInstance.save(flush: true)) {
            render(view: "create", model: [institutionInstance: institutionInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'institution.label', default: 'Institution'), institutionInstance.id])
        redirect(action: "show", id: institutionInstance.id)
    }

    def show() {
        def institutionInstance = Institution.get(params.id)
        if (!institutionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'institution.label', default: 'Institution'), params.id])
            redirect(action: "list")
            return
        }

        [institutionInstance: institutionInstance]
    }

    def edit() {
        def institutionInstance = Institution.get(params.id)
        if (!institutionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'institution.label', default: 'Institution'), params.id])
            redirect(action: "list")
            return
        }

        [institutionInstance: institutionInstance]
    }

    def update() {
        def institutionInstance = Institution.get(params.id)
        if (!institutionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'institution.label', default: 'Institution'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (institutionInstance.version > version) {
                institutionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'institution.label', default: 'Institution')] as Object[],
                          "Another user has updated this Institution while you were editing")
                render(view: "edit", model: [institutionInstance: institutionInstance])
                return
            }
        }

        institutionInstance.properties = params

        if (!institutionInstance.save(flush: true)) {
            render(view: "edit", model: [institutionInstance: institutionInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'institution.label', default: 'Institution'), institutionInstance.id])
        redirect(action: "show", id: institutionInstance.id)
    }

    def delete() {
        def institutionInstance = Institution.get(params.id)
        if (!institutionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'institution.label', default: 'Institution'), params.id])
            redirect(action: "list")
            return
        }

        try {
            institutionInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'institution.label', default: 'Institution'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'institution.label', default: 'Institution'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
    
    */
}
