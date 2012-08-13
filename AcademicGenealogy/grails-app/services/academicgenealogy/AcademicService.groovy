package academicgenealogy

import groovy.xml.MarkupBuilder

class AcademicService {
	
	def generateTree(currentAcademic, depth) {
		def writer =  new StringWriter()
		def xml = new MarkupBuilder(writer)
		generateTree(xml, currentAcademic, depth)
		return writer.toString()
	}
	
	private def generateTree(builder, currentAcademic, depth) {
		if (depth == 0 || currentAcademic == null) { return }
	    else {
			builder.current(name:currentAcademic.toString(), id:currentAcademic.id, expanded:true) {
				for (person in currentAcademic.supervises) {
					generateTree(builder, person, depth-1)
				}
			}
		}
	}
}