package academicgenealogy

class Institution {
	String name
	static hasMany = [academics:Academic]
	
    static constraints = {
    }
}
