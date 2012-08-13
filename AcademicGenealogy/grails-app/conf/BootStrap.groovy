import academicgenealogy.*

class BootStrap {

    def init = { servletContext ->
		
		//Set up security (if changing name of authority, annotation in AcademicController must be changed)
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush:true)
		def adminUser = new User(username:'admin', enabled:true, password:'admin').save(flush:true)
		UserRole.create(adminUser, adminRole, true)
		def superRole = new Role(authority: 'ROLE_SUPER').save(flush:true)
		def superUser = new User(username:'super', enabled:true, password:'super').save(flush:true)
		UserRole.create(superUser, superRole, true)

		
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
		def deity = new Academic(firstName:'Overlord', middleName:'H.', lastName:'Deity', country:all, institution:uall).save(failOnError:true)
		def soc = new Academic(firstName:'Socrates', middleName:'', lastName:'Alopece', country:gre, institution:soac, supervisor:deity).save(failOnError:true)
		def pla = new Academic(firstName:'Plato', middleName:'', lastName:'Athens', country:gre, institution:soac, supervisor:soc).save(failOnError:true)
		def ari = new Academic(firstName:'Aristotle', middleName:'', lastName:'Chalcidice', country:gre, institution:plac, supervisor:pla).save(failOnError:true)
		def ale = new Academic(firstName:'Alexander', middleName:'The', lastName:'Great', country:gre, institution:plac, supervisor:ari).save(failOnError:true)
		def newt = new Academic(firstName:'Isaac', middleName:'', lastName:'Newton', country:eng, institution:uox, supervisor:deity).save(failOnError:true)
		def alan = new Academic(firstName:'Alan', middleName:'', lastName:'Turing', country:eng, institution:uman, supervisor:newt).save(failOnError:true)
		def tim = new Academic(firstName:'Tim', middleName:'T.', lastName:'O\'Tim', country:aus, institution:uq, supervisor:alan).save(failOnError:true)
		def jeff = new Academic(firstName:'Geoffrey', middleName:'J.', lastName:'Jefferson', country:nz, institution:uau, supervisor:alan).save(failOnError:true)
		def bob = new Academic(firstName:'Robert', middleName:'R.', lastName:'Robson', country:png, institution:upng, supervisor:alan).save(failOnError:true)
		//Create fields
		def sci = new Field(name:'Science', description:'').save(failOnError:true)
		def cs = new Field(name:'Computer Science', description:'', parentField:sci).save(failOnError:true)
		def ai = new Field(name:'Artificial Intelligence', description:'', parentField:cs).save(failOnError:true)
		def phy = new Field(name:'Physics', description:'', parentField:sci).save(failOnError:true)
		def hum = new Field(name:'Humanities', description:'').save(failOnError:true)
		def ir = new Field(name:'International Relations', description:'', parentField:hum).save(failOnError:true)
		//Create thesises
		def pri = new Thesis(name:'Philosophiae Naturalis Principia Mathematica', published:new Date(1685,6,6), fields:[phy, sci], author:newt).save(failOnError:true)
		def comp = new Thesis(name:'On Computable Numbers, with an Application to the Entscheidungs Problem', published:new Date(1936,6,6), author:alan, fields:[cs, sci]).save(failOnError:true)
		def meta = new Thesis(name:"On the Nature of Meta-Physics", published:new Date(0,1,1), fields:[hum], author:pla).save(failOnError:true)
    }
    def destroy = {
    }
}
