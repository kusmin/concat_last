package concat

class Moeda {

    String nome
    String Simbolo

    static constraints = {
        nome nullable:false, blank:false, maxSize:64
        simbolo nullable:false, blank:false, maxSize:4, unique:true
    }

}
