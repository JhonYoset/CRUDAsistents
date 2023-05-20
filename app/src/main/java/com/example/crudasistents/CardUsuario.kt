package com.example.crudasistents
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable
fun CardUsuario(
    funNombre: (String) -> Unit,
    funInscripcion: (String) -> Unit,
    funTipoSangre:(String) -> Unit,
    funTelefono:(String) -> Unit,
    funEmail: (String) -> Unit,
    funMonto:(String) -> Unit,
    funTextButton: (String) -> Unit,
    funIsEditando: (Boolean) -> Unit,
    usuario: Usuario,
    funBorrarUsuario: (String) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            Arrangement.Center
        ) {
            Text(
                text = usuario.nombre,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = usuario.inscripcion,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = usuario.tipoSangre,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = usuario.telefono,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = usuario.email,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = usuario.monto,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    onClick = {
                        funNombre(usuario.nombre)
                        funInscripcion(usuario.inscripcion)
                        funTipoSangre(usuario.tipoSangre)
                        funTelefono(usuario.telefono)
                        funEmail(usuario.email)
                        funMonto(usuario.monto)
                        funTextButton("Editar Usuario")
                        funIsEditando(true)
                    }
                ) {
                    Text(
                        color = Color.White,
                        text = "Editar"
                    )
                }
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors( Color.Red),
                    onClick = {
                        funBorrarUsuario(usuario.nombre)
                    }
                ) {
                    Text(
                        color = Color.White,
                        text = "Borrar"
                    )
                }
            }
        }
    }
}