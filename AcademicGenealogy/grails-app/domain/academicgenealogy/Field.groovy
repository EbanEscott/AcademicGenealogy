package academicgenealogy

class Field {
	String name
	String description
	static belongsTo = [thesises:Thesis, parentField:Field]
	static hasMany = [subFields: Field]

    static constraints = {
		name blank:false, maxSize:50
		description maxSize:1000
		thesises nullable:true
		parentField nullable:true
    }
}
