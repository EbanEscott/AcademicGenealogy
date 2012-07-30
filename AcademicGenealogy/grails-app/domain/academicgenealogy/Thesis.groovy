package academicgenealogy

class Thesis {
	String name
	Date published
	static hasMany = [fields:Field]
	static belongsTo = [author:Academic, supervisor:Academic]
	static mappedBy = [author:"published", supervisor:"supervises"]
	
    static constraints = {
		
		name maxSize:50, unique:true, blank:false
		published nullable:false
    }
}
