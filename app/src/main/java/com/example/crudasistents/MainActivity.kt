package com.example.crudasistents
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.crudasistents.ui.theme.CRUDAsistentsTheme
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            CRUDAsistentsTheme{

                val listaUsuarios = remember { mutableStateListOf<Usuario>() }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ScreenCRUD(listaUsuarios)
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenCRUD(listaUsuarios: MutableList<Usuario>) {

    var nombre by remember { mutableStateOf("") }
    var inscripcion by remember { mutableStateOf("") }
    var tipoSangre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var monto by remember { mutableStateOf("") }
    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Agregar Usuario") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(12.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        ) {
            Formulario(
                nombre = nombre,
                funNombre = { nombre = it },
                inscripcion = inscripcion,
                funInscripcion = { inscripcion = it },
                tipoSangre = tipoSangre,
                funTipoSangre = {tipoSangre = it},
                telefono = telefono,
                funTelefono ={telefono= it },
                email = email,
                funEmail = { email = it },
                monto = monto,
                funMonto = {monto=it},
                isEditando = isEditando,
                funIsEditando = { isEditando = false },
                textButton = textButton,
                funTextButton = { textButton = it },
                listaUsuarios = listaUsuarios,
                funResetCampos = {
                    nombre = ""
                    inscripcion = ""
                    tipoSangre = ""
                    telefono = ""
                    email = ""
                    monto = ""

                }
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(listaUsuarios) { usuario ->

                        CardUsuario(
                            funNombre = { nombre = it },
                            funInscripcion= { inscripcion = it },
                            funTipoSangre = { tipoSangre = it},
                            funTelefono = {telefono = it },
                            funEmail =  { email = it },
                            funMonto = {monto = it },
                            usuario = usuario,
                            funTextButton = { textButton = it },
                            funIsEditando = { isEditando = it },
                            funBorrarUsuario = { borrarUsuario(it, listaUsuarios) }
                        )
                    }
                }
            }
        }
    }
}

fun agregarUsuario(nombre: String, inscripcion:String,tipoSangre: String,telefono:String,email: String, monto: String,listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.add(Usuario(nombre, inscripcion, tipoSangre,telefono,email, monto))
}

fun editarUsuario(nombre: String, inscripcion:String,tipoSangre: String,telefono:String,email: String, monto: String,listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.forEach { usuario ->
        if (usuario.nombre == nombre) {
            usuario.inscripcion = inscripcion
            usuario.tipoSangre = tipoSangre
            usuario.telefono = telefono
            usuario.email = email
            usuario.monto= monto
        }
    }
}

fun borrarUsuario(nombre: String, listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.forEach { usuario ->
        if (usuario.nombre == nombre) {
            listaUsuarios.remove(usuario)
        }
    }
}