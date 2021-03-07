package concat

class Cotacao {

    BigDecimal valor
    Date data

    static belongsTo = [item:Item, moeda:Moeda, fornecedor:Fornecedor]
    // static mapping = { table name:'DDL_cotacao', schema:'dbo', catalog:'cotacoes' }

    static constraints = {
    }

}
