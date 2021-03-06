package com.yorisapp.customer.exception;

import java.util.Map;
import java.util.TreeMap;

public class Message {
    private final static Map<MessageDescription, ExceptionResponse> vMessageTypes = new TreeMap<MessageDescription, ExceptionResponse>(){{
        //General 0-50
        put(MessageDescription.validationFieldEmptyOrNull, new ExceptionResponse("1","El valor del campo [%s] no puede ser vacío o nulo.", "detalle -_-"));
        put(MessageDescription.stateNullOrEmpty, new ExceptionResponse("2","El estado consultado no puede ser vacío o nulo.", "detalle -_-"));
        put(MessageDescription.stateNotValid, new ExceptionResponse("3","El estado consultado %s no es permitido.", "detalle -_-"));
        put(MessageDescription.objectNull, new ExceptionResponse("10", "%s no puede ser nulo", "detalle -_-"));
        // Entitys 101-150
        put(MessageDescription.repeated, new ExceptionResponse("101","Existe un registro activo con el %s: %s", "detalle -_-"));
        put(MessageDescription.notExists, new ExceptionResponse("102","No se encontró %s con el %s: %s", "detalle -_-"));
        put(MessageDescription.notExists, new ExceptionResponse("103","Inserción incorrecta", "detalle -_-"));
        // contraseñas  251-300
        put(MessageDescription.incorrectPass, new ExceptionResponse("251","Contraseña incorrecta.", "detalle -_-"));
        // Usuarios 301-350
        put(MessageDescription.usernameNotFound, new ExceptionResponse("301","El username [%s] no se encuentra registrado.", "detalle -_-"));
        put(MessageDescription.userWithoutRoles, new ExceptionResponse("302","Error en el Login: usuario no tiene rols asignados", "detalle -_-"));
        put(MessageDescription.userWithoutResources, new ExceptionResponse("304","Error en el Login: usuario no tiene menúes asignados", "detalle -_-"));
        put(MessageDescription.userWithoutPermissions, new ExceptionResponse("305","Error en el Login: usuario no tiene permisos asignados", "detalle -_-"));
        put(MessageDescription.usernameDuplicated, new ExceptionResponse("306","El [%s] con username [%s] ya esta registrado", "detalle -_-"));
        put(MessageDescription.userAccessDenied, new ExceptionResponse("307","Accesos denegado al token.", "detalle -_-"));

    }};

    public static BadRequestException GetBadRequest(MessageDescription vMessageDescription, String value)
    {
        ExceptionResponse vMessageDetail = vMessageTypes.get(vMessageDescription);
        String vNewMessage = vMessageDetail.getMessage();
        vNewMessage = String.format(vNewMessage, value);
        return new BadRequestException(vMessageDetail.getCode(), vNewMessage);
    }

    public static BadRequestException GetBadRequest(MessageDescription tipo)
    {
        ExceptionResponse vMessageDetail = vMessageTypes.get(tipo);
        String vNewMessage = vMessageDetail.getMessage();
        return new BadRequestException(vMessageDetail.getCode(), vNewMessage);
    }

    public static BadRequestException GetBadRequest(MessageDescription pMessageDescription, Object[] pArgs)
    {
        ExceptionResponse vMessageDetail = vMessageTypes.get(pMessageDescription);
        String vNewMessage = vMessageDetail.getMessage();
        vNewMessage = String.format(vNewMessage, pArgs);
        return new BadRequestException(vMessageDetail.getCode(), vNewMessage);
    }
    public static NotFoundException GetNotFound(MessageDescription pMessageDescription, Object[] pArgs)
    {
        ExceptionResponse vMessageDetail = vMessageTypes.get(pMessageDescription);
        String vNewMessage = vMessageDetail.getMessage();
        vNewMessage = String.format(vNewMessage, pArgs);
        return new NotFoundException(vMessageDetail.getCode(), vNewMessage);
    }

    public static NotFoundException GetNotFound(MessageDescription pMessageDescription, String pArgs)
    {
        ExceptionResponse messageDetail = vMessageTypes.get(pMessageDescription);
        String newMessage = messageDetail.getMessage();
        newMessage = String.format(newMessage, pArgs);
        return new NotFoundException(messageDetail.getCode(), newMessage);
    }
}
