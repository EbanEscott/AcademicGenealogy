package academicgenealogy



import org.junit.*
import grails.test.mixin.*

@TestFor(InstitutionController)
@Mock(Institution)
class InstitutionControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/institution/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.institutionInstanceList.size() == 0
        assert model.institutionInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.institutionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.institutionInstance != null
        assert view == '/institution/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/institution/show/1'
        assert controller.flash.message != null
        assert Institution.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/institution/list'


        populateValidParams(params)
        def institution = new Institution(params)

        assert institution.save() != null

        params.id = institution.id

        def model = controller.show()

        assert model.institutionInstance == institution
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/institution/list'


        populateValidParams(params)
        def institution = new Institution(params)

        assert institution.save() != null

        params.id = institution.id

        def model = controller.edit()

        assert model.institutionInstance == institution
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/institution/list'

        response.reset()


        populateValidParams(params)
        def institution = new Institution(params)

        assert institution.save() != null

        // test invalid parameters in update
        params.id = institution.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/institution/edit"
        assert model.institutionInstance != null

        institution.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/institution/show/$institution.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        institution.clearErrors()

        populateValidParams(params)
        params.id = institution.id
        params.version = -1
        controller.update()

        assert view == "/institution/edit"
        assert model.institutionInstance != null
        assert model.institutionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/institution/list'

        response.reset()

        populateValidParams(params)
        def institution = new Institution(params)

        assert institution.save() != null
        assert Institution.count() == 1

        params.id = institution.id

        controller.delete()

        assert Institution.count() == 0
        assert Institution.get(institution.id) == null
        assert response.redirectedUrl == '/institution/list'
    }
}
