package academicgenealogy

class Academic {
	String firstName
	String middleName
	String lastName
	static hasMany = [supervises:Thesis]
	static hasOne = [published:Thesis]
	static belongsTo = [institution:Institution, country:Country]
	static mappedBy = [published:"author", supervises:"supervisors"]
	
    static constraints = {
    }
}