package academicgenealogy

class Thesis {
	String name
	Date published
	static hasMany = [fields:Field]
	static belongsTo = [author:Academic, supervisors:Academic]
	static mappedBy = [author:"published", supervisors:"supervises"]
	
    static constraints = {
    }
}
