package academicgenealogy

class Field {
	String name
	String description
	static belongsTo = [thesises:Thesis, parentField:Field]
	static hasMany = [subFields: Field]

    static constraints = {
    }
}
