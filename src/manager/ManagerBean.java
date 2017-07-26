package manager;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import persistence.AgendaDao;
import entity.Agenda;

@ManagedBean(name="mb")
@ViewScoped
public class ManagerBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Agenda agenda;
	private DataModel listaAgenda;
	private Agenda agendaAltera;
	
	@PostConstruct
	public void init(){
		agenda = new Agenda();
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public DataModel getListaAgenda() {
		listaAgenda = new ListDataModel( new AgendaDao().findAll() );
		return listaAgenda;
	}

	public void setListaAgenda(DataModel listaAgenda) {
		this.listaAgenda = listaAgenda;
	}

	public Agenda getAgendaAltera() {
		return agendaAltera;
	}

	public void setAgendaAltera(Agenda agendaAltera) {
		this.agendaAltera = agendaAltera;
	}

	public void cadastrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try{
			
			new AgendaDao().create(agenda);
			agenda = new Agenda();
			fc.addMessage("form2", new FacesMessage("Dados Gravados!"));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void excluir(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try{
			
			new AgendaDao().delete((Agenda) listaAgenda.getRowData());
			fc.addMessage("form2", new FacesMessage("Dados Excluidos!!"));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void alterar1(){
		agendaAltera = (Agenda) listaAgenda.getRowData();
	}
	
	public void alterar2(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try{
			
			new AgendaDao().update(agendaAltera);
			fc.addMessage("form2", new FacesMessage("Dados Alterados!"));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
