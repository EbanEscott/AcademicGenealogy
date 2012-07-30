import academicgenealogy.*

class BootStrap {

    def init = { servletContext ->
		
		
		//Create countries
		def aus = new Country(name:'Australia').save(failOnError:true)
		def nz = new Country(name:'New Zealand').save(failOnError:true)
		def png = new Country(name:'Papua New Guinea').save(failOnError:true)
		
		def gre = new Country(name:'Greece').save(failOnError:true)
		def eng = new Country(name:'England').save(failOnError:true)
		
		def all = new Country(name:'All').save(failOnError:true)
		
		//Create institutions
		def uq = new Institution(name:'University of Queensland').save(failOnError:true)
		def uau = new Institution(name:'University of Auckland').save(failOnError:true)
		def upng = new Institution(name:'University of Papua New Guinea').save(failOnError:true)
		
		def soac = new Institution(name:'Socrates\' Academy').save(failOnError:true)
		def plac = new Institution(name:'Plato\'s Academy').save(failOnError:true)
		
		def uman = new Institution(name:'University of Manchester').save(failOnError:true)
		def uox = new Institution(name:'University of Oxford').save(failOnError:true)
		
		def uall = new Institution(name:'University of All').save(failOnError:true)
		
		//Create academics
		def tim = new Academic(firstName:'Tim', middleName:'T.', lastName:'O\'Tim', country:aus, institution:uq).save(failOnError:true)
		def jeff = new Academic(firstName:'Geoffrey', middleName:'J.', lastName:'Jefferson', country:nz, institution:uau).save(failOnError:true)
		def bob = new Academic(firstName:'Robert', middleName:'R.', lastName:'Robson', country:png, institution:upng).save(failOnError:true)
		
		def soc = new Academic(firstName:'Socrates', middleName:'', lastName:'Alopece', country:gre, institution:soac).save(failOnError:true)
		def pla = new Academic(firstName:'Plato', middleName:'', lastName:'Athens', country:gre, institution:soac).save(failOnError:true)
		def ari = new Academic(firstName:'Aristotle', middleName:'', lastName:'Chalcidice', country:gre, institution:plac).save(failOnError:true)
		
		def alan = new Academic(firstName:'Alan', middleName:'', lastName:'Turing', country:eng, institution:uman).save(failOnError:true)
		
		def newt = new Academic(firstName:'Isaac', middleName:'', lastName:'Newton', country:eng, institution:uox).save(failOnError:true)
		
		def deity = new Academic(firstName:'Overlord', middleName:'H.', lastName:'Deity', country:all)
		
		//Create fields
		def sci = new Field(name:'Science', description:'').save(failOnError:true)
		def cs = new Field(name:'Computer Science', description:'', parentField:sci).save(failOnError:true)
		def ai = new Field(name:'Artificial Intelligence', description:'', parentField:cs).save(failOnError:true)
		def phy = new Field(name:'Physics', description:'', parentField:sci).save(failOnError:true)
		
		def hum = new Field(name:'Humanities', description:'').save(failOnError:true)
		def ir = new Field(name:'International Relations', description:'', parentField:hum).save(failOnError:true)
		
		//Create thesises
		//def pri = new Thesis(name:'Philosophiæ Naturalis Principia Mathematica', published:new Date(1685,6,6), fields:[phy], author:newt, supervisor:deity).save(failOnError:true)
		//def comp = new Thesis(name:'On Computable Numbers, with an Application to the Entscheidungs Problem', published:new Date(1936,6,6), author:alan, fields:[cs], supervisor:deity).save(failOnError:true)
    }
    def destroy = {
    }
}
