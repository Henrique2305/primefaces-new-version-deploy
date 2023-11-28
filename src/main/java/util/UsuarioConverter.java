package util;

import model.Endereco;
import model.Usuario;

public class UsuarioConverter {

    public static Usuario transformBOModelForUpdate(Usuario u1, Usuario u2) {
        Endereco endereco = new Endereco();

        endereco.setId(u2.getEndereco().getId());
        endereco.setRua(u1.getEndereco().getRua().isEmpty() ? u2.getEndereco().getRua() : u1.getEndereco().getRua());
        endereco.setNumero(u1.getEndereco().getNumero() == null ? u2.getEndereco().getNumero() : u1.getEndereco().getNumero());
        endereco.setCidade(u1.getEndereco().getCidade().isEmpty() ? u2.getEndereco().getCidade() : u1.getEndereco().getCidade());
        endereco.setUF(u1.getEndereco().getUF().isEmpty() ? u2.getEndereco().getUF() : u1.getEndereco().getUF());
        endereco.setComplemento(u1.getEndereco().getComplemento().isEmpty() ? u2.getEndereco().getComplemento() : u1.getEndereco().getComplemento());
        endereco.setCEP(u1.getEndereco().getCEP().isEmpty() ? u2.getEndereco().getCEP() : u1.getEndereco().getCEP());

        u2.setId(u1.getEndereco().getId() == null ? u2.getId() : u1.getId());
        u2.setNome(u1.getNome().isEmpty() ? u2.getNome() : u1.getNome());
        u2.setEmail(u1.getEmail().isEmpty() ? u2.getEmail() : u1.getEmail());
        u2.setCPF(u1.getCPF().isEmpty() ? u2.getCPF() : u1.getCPF());
        u2.setEndereco(endereco);

        return u2;
    }
}
