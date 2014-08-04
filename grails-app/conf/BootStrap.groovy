import com.nest5.Nest5Client.City
import com.nest5.Nest5Client.Company
import com.nest5.Nest5Client.Country
import com.nest5.Nest5Client.SecRole
import com.nest5.Nest5Client.SecUserSecRole
import com.nest5.Nest5Client.Category
import com.nest5.Nest5Client.Icon
import com.nest5.Nest5Client.Seller
import com.nest5.Nest5Client.User

class BootStrap {

    def init = { servletContext ->
        def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)
        def apiRole = SecRole.findByAuthority('ROLE_API') ?: new SecRole(authority: 'ROLE_API').save(failOnError: true)
        def facebookRole = SecRole.findByAuthority('ROLE_FACEBOOK') ?: new SecRole(authority: 'ROLE_FACEBOOK').save(failOnError: true)
        def companyRole = SecRole.findByAuthority('ROLE_COMPANY') ?: new SecRole(authority: 'ROLE_COMPANY').save(failOnError: true)
        def sellerRole = SecRole.findByAuthority('ROLE_SELLER') ?: new SecRole(authority: 'ROLE_SELLER').save(failOnError: true)
        def memberRole =  SecRole.findByAuthority('ROLE_MEMBER') ?: new SecRole(authority: 'ROLE_MEMBER').save(failOnError: true)

        def adminUser = User.findByUsername('admin') ?: new User(
                username: 'admin',
                password: 'farroyavefami',
                enabled: true,
                name : 'Juan David Arroyave Henao',
                email: 'juanda6@gmail.com',
                smartphone: true,
                smartphoneBrand: 'Android-Samsung',
                phone: '3014597229',
                referer: 'none',
                date: '1986/01/13').save(failOnError: true)






        def icon = Icon.findByName('dummyIcon') ?: new Icon(
                name: 'dummyIcon',
                tipo: 'image/png',
                ruta: 'https://s3-us-west-2.amazonaws.com/com.nest5.assets/user-profile/bola_80.png',
                description: 'Logo de Nest5'
        ).save(failOnError: true)


        def dummyCompany = Company.findByUsername('dummyCompany') ?: new Company(

                category: Category.findByName('Ninguna') ?: new Category(name: 'Ninguna', description: 'Sin clasificacion posible.',icon: icon).save(failOnError: true),
                username: 'dummyCompany',
                password: 'farroyavefami',
                enabled: true,
                name : "Dummy Company",
                address: "NA",
                telephone: "00",
                contactName: "NA",
                email: "NA@NA.com",
                nit: "0000",
                logo : "NA",
                url : "http://",
                registerDate: new Date(),
                active: false
        ).save(failOnError: true)


        def dummySeller = Seller.findByUsername('prueba@vendedores.com') ?: new Seller(

                company: Company.findByUsername('minegocio@gmail.com') ?: dummyCompany,
                username: 'prueba@vendedores.com',
                password: 'farroyavefami',
                enabled: true,
                name : "Dummy Seller",
                telephone: "00",
                email: "prueba@vendedores.com",
                registerDate: new Date(),
                active: true,
                identification: '71527117'
        ).save(failOnError: true)

        if (!adminUser.authorities.contains(adminRole)) {
            SecUserSecRole.create adminUser, adminRole
        }
        if (!dummySeller.authorities.contains(sellerRole)) {
            SecUserSecRole.create dummySeller, sellerRole
        }
        if (!dummyCompany.authorities.contains(companyRole)) {
            SecUserSecRole.create dummyCompany, companyRole
        }

//        Create countries and cities
        def colombia = Country.findByCode("CO") ?: new Country(
                name: "Colombia",
                code: "CO",
                locale: "es_CO",

        ).save(failOnError: true)
        def unknownCountry = Country.findByCode("NA") ?: new Country(
                name: "Unknown",
                code: "NA",
                locale: "es_CO",

        ).save(failOnError: true)

        def medellin = City.findByCode("medellin") ?: new City(
                name: "Medellín",
                code: "medellin",
                latitude: 6.253189,
                longitude: -75.573685,
                country: colombia

        ).save(failOnError: true)
        def bogota = City.findByCode("bogota") ?: new City(
                name: "Bogotá",
                code: "bogota",
                latitude: 4.713303,
                longitude: -74.076176,
                country: colombia

        ).save(failOnError: true)
        def unknownCity = City.findByCode("unknown") ?: new City(
                name: "Unknown",
                code: "unknown",
                latitude: 4.713303,
                longitude: -74.076176,
                country: unknownCountry

        ).save(failOnError: true)
    }
    def destroy = {
    }
}