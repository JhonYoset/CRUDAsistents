package com.example.crudasistents
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulario(
    nombre: String,
    funNombre: (String) -> Unit,
    inscripcion: String,
    funInscripcion: (String) -> Unit,
    tipoSangre: String,
    funTipoSangre: (String) -> Unit,
    telefono: String,
    funTelefono: (String) -> Unit,
    email: String,
    funEmail: (String) -> Unit,
    monto: String,
    funMonto: (String) -> Unit,
    isEditando: Boolean,
    funIsEditando: () -> Unit,
    textButton: String,
    funTextButton: (String) -> Unit,
    listaUsuarios: MutableList<Usuario>,
    funResetCampos: () -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nombre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funNombre(it) },
        label = { Text(text = "Nombre") },
        //enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = inscripcion,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funInscripcion(it) },
        label = { Text(text = "Inscripcion") },
        //enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = tipoSangre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funTipoSangre(it) },
        label = { Text(text = "Tipo De Sangre") },
        //enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = telefono,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funTelefono(it) },
        label = { Text(text = "Telefono") },
        //enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funEmail(it) },
        label = { Text(text = "Email") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = monto,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funMonto(it) },
        label = { Text(text = "Monto") },
        //enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    Button(modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.DarkGray),
        onClick = {
            if (isEditando) {
                editarUsuario(nombre, inscripcion,tipoSangre,telefono,email,monto, listaUsuarios)
                funTextButton("Agregar Usuario")
                funIsEditando()

            } else {
                agregarUsuario(nombre, inscripcion,tipoSangre,telefono,email,monto, listaUsuarios)
            }
            funResetCampos()
        }
    ) {
        Text(
            color = Color.White,
            text = textButton
        )
    }
}