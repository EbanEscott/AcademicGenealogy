package academicgenealogy

import groovy.xml.MarkupBuilder

class AcademicService {

	private def writer
	private def xml
	
	def generateTree(currentAcademic, depth) {
		writer =  new StringWriter()
		xml = new MarkupBuilder(writer)
		return generateTree(xml, currentAcademic, depth)
	}
	
	private def generateTree(builder, currentAcademic, depth) {
		if (depth == 0 || currentAcademic == null) { return writer.toString()}
	    else {
			builder.current(name:currentAcademic.toString(), id:currentAcademic.id, expanded:true) {
				for (person in currentAcademic.supervises) {
					generateTree(builder, person, depth-1)
				}
			}
			return writer.toString()
		}
	}
}