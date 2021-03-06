package academicgenealogy

class Thesis {
	String name
	Date published
	static hasMany = [fields:Field]
	static belongsTo = [author:Academic]
	static mappedBy = [author:"published"]
	
    static constraints = {
		
		name maxSize:150, unique:true, blank:false
		published nullable:false
    }
	
	String toString() {
		return this.name
	}
}
