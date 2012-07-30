package academicgenealogy



import org.junit.*
import grails.test.mixin.*

@TestFor(TreeController)
@Mock(Tree)
class TreeControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/tree/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.treeInstanceList.size() == 0
        assert model.treeInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.treeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.treeInstance != null
        assert view == '/tree/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/tree/show/1'
        assert controller.flash.message != null
        assert Tree.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/tree/list'


        populateValidParams(params)
        def tree = new Tree(params)

        assert tree.save() != null

        params.id = tree.id

        def model = controller.show()

        assert model.treeInstance == tree
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/tree/list'


        populateValidParams(params)
        def tree = new Tree(params)

        assert tree.save() != null

        params.id = tree.id

        def model = controller.edit()

        assert model.treeInstance == tree
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/tree/list'

        response.reset()


        populateValidParams(params)
        def tree = new Tree(params)

        assert tree.save() != null

        // test invalid parameters in update
        params.id = tree.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/tree/edit"
        assert model.treeInstance != null

        tree.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/tree/show/$tree.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        tree.clearErrors()

        populateValidParams(params)
        params.id = tree.id
        params.version = -1
        controller.update()

        assert view == "/tree/edit"
        assert model.treeInstance != null
        assert model.treeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/tree/list'

        response.reset()

        populateValidParams(params)
        def tree = new Tree(params)

        assert tree.save() != null
        assert Tree.count() == 1

        params.id = tree.id

        controller.delete()

        assert Tree.count() == 0
        assert Tree.get(tree.id) == null
        assert response.redirectedUrl == '/tree/list'
    }
}
