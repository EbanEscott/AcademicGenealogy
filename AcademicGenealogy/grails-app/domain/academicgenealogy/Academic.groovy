package academicgenealogy

class Academic {
	
	String firstName
	String middleName
	String lastName
	static hasMany = [supervises:Academic]
	static hasOne = [published:Thesis]
	static belongsTo = [institution:Institution, country:Country, supervisor:Academic]
	static mappedBy = [published:"author", supervises:"supervisor"]
	
	static searchFields = {
		firstName
		middleName
		lastName
	}
	
    static constraints = {
		firstName blank:false, maxSize:50
		middleName maxSize:50
		lastName blank:false, maxSize:50
		published nullable:true
    }
}