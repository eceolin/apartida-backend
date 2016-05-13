/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.isports.ejb.converter;

import br.com.isports.bean.usuarioservice.UsuarioDTO;
import br.com.isports.entity.entities.Usuario;

/**
 *
 * @author dudu
 */
public abstract class UsuarioConverter extends AbstractConverter {

    public static UsuarioDTO entityToDTO(Usuario entity) throws NullPointerException{
        UsuarioDTO dto = new UsuarioDTO();

        dto.setId(entity.getId());
        dto.setLogin(entity.getLogin());
        dto.setNome(entity.getNome());
        dto.setSenha(entity.getSenha());
        dto.setAdmin(entity.getAdmin());

        if (entity.getPerfil() != null) {
            dto.setPerfil(PerfilConverter.entityToDTO(entity.getPerfil()));
        }

        return dto;
    }

    public static Usuario dtoToEntity(UsuarioDTO dto) throws NullPointerException{
        Usuario entity = new Usuario();

        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setAdmin(dto.getAdmin());
        entity.setLogin(dto.getLogin());
        entity.setNome(dto.getNome());
        entity.setPerfil(PerfilConverter.dtoToEntity(dto.getPerfil()));

        return entity;
    }
}
