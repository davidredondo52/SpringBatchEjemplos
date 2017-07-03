package expedientesx.modelo.negocio;

import java.util.List;

import expedientesx.modelo.entidad.Expediente;

public interface GestorExpendientes {
	
	//@Secured("ROLE_AGENTE_ESPECIAL,ROLE_DIRECTOR")
	//@PreAuthorize("hasRole('ROLE_DIRECTOR')")
	void clasificar(Expediente expediente);

	//@Secured("ROLE_AGENTE_ESPECIAL,ROLE_DIRECTOR")
	//@RolesAllowed("ROLE_AGENTE_ESPECIAL,ROLE_DIRECTOR")
	//@PreAuthorize("hasRole('ROLE_DIRECTOR') "+
	//		      "or #expediente.investigador == authentication.name")
	void desclasificar(Expediente expediente);

	//@PostFilter("not filterObject.informe.contains(principal.username)")
	List<Expediente> listarTodos();

	//@PreAuthorize("hasAnyRole('ROLE_AGENTE_ESPECIAL','ROLE_DIRECTOR')")
	//@PostAuthorize("hasRole('ROLE_DIRECTOR') "
	//		+ "or returnObject.investigador == authentication.name")
	Expediente mostrar(Long id);
}




