package agenda_contacto.data;

import agenda_contacto.dominio.Contacto;

import java.util.List;

public interface ContactoDao {

    public void newContacto(Contacto contacto);
    public List<Contacto> listContactos();
    public Contacto getContacto(Contacto contacto);
    public Contacto findByTelefono(Contacto contacto);
    public void deleteContacto(Contacto contacto);

}
