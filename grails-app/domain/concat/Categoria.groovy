package concat

class Categoria {

    String nome
    String toString() {
        this.nome
    }

    static hasMany = [itens:Item]

    static constraints = {
        nome nullable:false, blank:false, maxSize:128, unique:true
    }

}
