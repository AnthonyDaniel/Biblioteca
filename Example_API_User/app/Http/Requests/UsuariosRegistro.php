<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class UsuariosRegistro extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     *
     * @return bool
     */
    public function authorize()
    {
        return false;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array
     */
    public function rules()
    {
        //      'id','cedula','nombre','apellidos','telefono','email'
        return [
            'cedula' => 'required|unique:usuarios',
            'nombre' => 'required',
            'apellidos' => 'required',
            'telefono' => 'required|unique:usuarios',
            'email' => 'required|email|unique:usuarios'
        ];
    }
}
