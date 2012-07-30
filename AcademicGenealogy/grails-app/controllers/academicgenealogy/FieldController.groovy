package academicgenealogy

import org.springframework.dao.DataIntegrityViolationException

class FieldController {
	
	static scaffold = Field
	
	/*

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [fieldInstanceList: Field.list(params), fieldInstanceTotal: Field.count()]
    }

    def create() {
        [fieldInstance: new Field(params)]
    }

    def save() {
        def fieldInstance = new Field(params)
        if (!fieldInstance.save(flush: true)) {
            render(view: "create", model: [fieldInstance: fieldInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'field.label', default: 'Field'), fieldInstance.id])
        redirect(action: "show", id: fieldInstance.id)
    }

    def show() {
        def fieldInstance = Field.get(params.id)
        if (!fieldInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'field.label', default: 'Field'), params.id])
            redirect(action: "list")
            return
        }

        [fieldInstance: fieldInstance]
    }

    def edit() {
        def fieldInstance = Field.get(params.id)
        if (!fieldInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'field.label', default: 'Field'), params.id])
            redirect(action: "list")
            return
        }

        [fieldInstance: fieldInstance]
    }

    def update() {
        def fieldInstance = Field.get(params.id)
        if (!fieldInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'field.label', default: 'Field'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (fieldInstance.version > version) {
                fieldInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'field.label', default: 'Field')] as Object[],
                          "Another user has updated this Field while you were editing")
                render(view: "edit", model: [fieldInstance: fieldInstance])
                return
            }
        }

        fieldInstance.properties = params

        if (!fieldInstance.save(flush: true)) {
            render(view: "edit", model: [fieldInstance: fieldInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'field.label', default: 'Field'), fieldInstance.id])
        redirect(action: "show", id: fieldInstance.id)
    }

    def delete() {
        def fieldInstance = Field.get(params.id)
        if (!fieldInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'field.label', default: 'Field'), params.id])
            redirect(action: "list")
            return
        }

        try {
            fieldInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'field.label', default: 'Field'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'field.label', default: 'Field'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
    */
}
