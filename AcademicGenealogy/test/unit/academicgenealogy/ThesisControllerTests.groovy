package academicgenealogy



import org.junit.*
import grails.test.mixin.*

@TestFor(ThesisController)
@Mock(Thesis)
class ThesisControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/thesis/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.thesisInstanceList.size() == 0
        assert model.thesisInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.thesisInstance != null
    }

    void testSave() {
        controller.save()

        assert model.thesisInstance != null
        assert view == '/thesis/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/thesis/show/1'
        assert controller.flash.message != null
        assert Thesis.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/thesis/list'


        populateValidParams(params)
        def thesis = new Thesis(params)

        assert thesis.save() != null

        params.id = thesis.id

        def model = controller.show()

        assert model.thesisInstance == thesis
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/thesis/list'


        populateValidParams(params)
        def thesis = new Thesis(params)

        assert thesis.save() != null

        params.id = thesis.id

        def model = controller.edit()

        assert model.thesisInstance == thesis
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/thesis/list'

        response.reset()


        populateValidParams(params)
        def thesis = new Thesis(params)

        assert thesis.save() != null

        // test invalid parameters in update
        params.id = thesis.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/thesis/edit"
        assert model.thesisInstance != null

        thesis.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/thesis/show/$thesis.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        thesis.clearErrors()

        populateValidParams(params)
        params.id = thesis.id
        params.version = -1
        controller.update()

        assert view == "/thesis/edit"
        assert model.thesisInstance != null
        assert model.thesisInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/thesis/list'

        response.reset()

        populateValidParams(params)
        def thesis = new Thesis(params)

        assert thesis.save() != null
        assert Thesis.count() == 1

        params.id = thesis.id

        controller.delete()

        assert Thesis.count() == 0
        assert Thesis.get(thesis.id) == null
        assert response.redirectedUrl == '/thesis/list'
    }
}
