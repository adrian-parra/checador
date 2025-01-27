import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface, // Color por defecto con el tema
    fontSize: Float = 16f,  // Tamaño de fuente por defecto
    fontWeight: androidx.compose.ui.text.font.FontWeight = androidx.compose.ui.text.font.FontWeight.Normal, // Peso de la fuente
    style: TextStyle = TextStyle.Default // Puedes agregar más personalización aquí
) {
    Text(
        text = text,
        modifier = modifier.padding(8.dp),  // Padding opcional
        color = color,
        fontSize = fontSize.sp,  // Convertimos el tamaño de fuente a sp
        fontWeight = fontWeight,
        style = style
    )
}
