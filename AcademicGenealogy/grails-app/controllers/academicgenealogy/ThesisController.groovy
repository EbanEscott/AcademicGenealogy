package academicgenealogy

import org.springframework.dao.DataIntegrityViolationException

class ThesisController {
	
	static scaffold = Thesis
	
	/*

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [thesisInstanceList: Thesis.list(params), thesisInstanceTotal: Thesis.count()]
    }

    def create() {
        [thesisInstance: new Thesis(params)]
    }

    def save() {
        def thesisInstance = new Thesis(params)
        if (!thesisInstance.save(flush: true)) {
            render(view: "create", model: [thesisInstance: thesisInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'thesis.label', default: 'Thesis'), thesisInstance.id])
        redirect(action: "show", id: thesisInstance.id)
    }

    def show() {
        def thesisInstance = Thesis.get(params.id)
        if (!thesisInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'thesis.label', default: 'Thesis'), params.id])
            redirect(action: "list")
            return
        }

        [thesisInstance: thesisInstance]
    }

    def edit() {
        def thesisInstance = Thesis.get(params.id)
        if (!thesisInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'thesis.label', default: 'Thesis'), params.id])
            redirect(action: "list")
            return
        }

        [thesisInstance: thesisInstance]
    }

    def update() {
        def thesisInstance = Thesis.get(params.id)
        if (!thesisInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'thesis.label', default: 'Thesis'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (thesisInstance.version > version) {
                thesisInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'thesis.label', default: 'Thesis')] as Object[],
                          "Another user has updated this Thesis while you were editing")
                render(view: "edit", model: [thesisInstance: thesisInstance])
                return
            }
        }

        thesisInstance.properties = params

        if (!thesisInstance.save(flush: true)) {
            render(view: "edit", model: [thesisInstance: thesisInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'thesis.label', default: 'Thesis'), thesisInstance.id])
        redirect(action: "show", id: thesisInstance.id)
    }

    def delete() {
        def thesisInstance = Thesis.get(params.id)
        if (!thesisInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'thesis.label', default: 'Thesis'), params.id])
            redirect(action: "list")
            return
        }

        try {
            thesisInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'thesis.label', default: 'Thesis'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'thesis.label', default: 'Thesis'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
    
    */
}
