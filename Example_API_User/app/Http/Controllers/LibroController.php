<?php

namespace App\Http\Controllers;
use App\Libro;
use Illuminate\Http\Request;

class LibroController extends Controller
{
    public function GetByTitle($titulo)
    {
        try{
            $data = Libro::where('titulo', 'LIKE', '%'.$titulo.'%')->get();
            return response()->json($data,200);
        }catch (\Throwable $th) {
            return  response()->json(['error' => 'Not found'], 404);
        }
    }
}
