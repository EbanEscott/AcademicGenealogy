package academicgenealogy



import org.junit.*
import grails.test.mixin.*

@TestFor(AcademicController)
@Mock(Academic)
class AcademicControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/academic/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.academicInstanceList.size() == 0
        assert model.academicInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.academicInstance != null
    }

    void testSave() {
        controller.save()

        assert model.academicInstance != null
        assert view == '/academic/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/academic/show/1'
        assert controller.flash.message != null
        assert Academic.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/academic/list'


        populateValidParams(params)
        def academic = new Academic(params)

        assert academic.save() != null

        params.id = academic.id

        def model = controller.show()

        assert model.academicInstance == academic
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/academic/list'


        populateValidParams(params)
        def academic = new Academic(params)

        assert academic.save() != null

        params.id = academic.id

        def model = controller.edit()

        assert model.academicInstance == academic
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/academic/list'

        response.reset()


        populateValidParams(params)
        def academic = new Academic(params)

        assert academic.save() != null

        // test invalid parameters in update
        params.id = academic.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/academic/edit"
        assert model.academicInstance != null

        academic.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/academic/show/$academic.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        academic.clearErrors()

        populateValidParams(params)
        params.id = academic.id
        params.version = -1
        controller.update()

        assert view == "/academic/edit"
        assert model.academicInstance != null
        assert model.academicInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/academic/list'

        response.reset()

        populateValidParams(params)
        def academic = new Academic(params)

        assert academic.save() != null
        assert Academic.count() == 1

        params.id = academic.id

        controller.delete()

        assert Academic.count() == 0
        assert Academic.get(academic.id) == null
        assert response.redirectedUrl == '/academic/list'
    }
}
