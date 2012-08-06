package academicgenealogy

class Country {
	String name
	static hasMany = [academics:Academic]
	
    static constraints = {
		name blank:false, maxSize:50
    }
	
	String toString() {
		return this.name
	}
}
