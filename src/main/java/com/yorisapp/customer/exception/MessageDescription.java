package com.yorisapp.customer.exception;

public enum MessageDescription {
    // General 0-50
    stateNullOrEmpty,
    stateNotValid,
    validationFieldEmptyOrNull,
    objectNull,
    // Entidades 101-150
    repeated,
    notExists,
    // Carga Masiva 151-200
    // contraseñas  251-300
    incorrectPass,
    // Usuarios 301-350
    usernameNotFound,
    usernameDuplicated,
    userWithoutRoles,
    userWithoutResources,
    userWithoutPermissions,
    userAccessDenied,

}
