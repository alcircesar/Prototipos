package br.com.prototipos.tasks.model;

public enum Situacao {
    NOVA("<i class='fa fa-flag fa-inverse text-muted' title='Nova'></i></span>","Nova",0), 
    EXCECUTANDO("<i class='fa fa-flag fa-inverse text-primary' title = 'Executando'></i>","Executando",10), 
    ATRASADA("<i class='fa fa-flag fa-inverse text-warning' title='Atrasada'></i>", "Atrasada",20), 
    FINALIZADA("<i class='fa fa-flag fa-inverse text-success' title='Finalizada'></i>","Finalizada",40), 
    CANCELADA("<i class='fa fa-flag fa-inverse  text-danger' title='Cancelada'></i> ","Cancelada",50);
    private String aparencia;
    private String descricao;
    private int estado;
    Situacao(String aparencia, String descricao, int estado){
        this.aparencia = aparencia;
        this.descricao = descricao;
        this.estado = estado;
    }
    
    public String getAparencia() {
        return this.aparencia;
    }

    public String getDescricao() {
        return this.descricao;
    }
    
    public int getEstado() {
        return this.estado;
    }
}
