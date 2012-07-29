package academicgenealogy

class Country {
	String name
	static hasMany = [academics:Academic]
	
    static constraints = {
    }
}
