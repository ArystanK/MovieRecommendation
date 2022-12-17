package kz.arctan.movierecommendation.common.presentation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LetsSeeTextField(
    value: String,
    onValueChange: (String) -> Unit,
    trailingIcon: (@Composable () -> Unit)? = null,
    placeholder: String? = null,
    singleLine: Boolean = true,
    elevation: Dp = 4.dp,
    isVisible: Boolean = true
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        trailingIcon = trailingIcon,
        placeholder = placeholder?.let { { Text(placeholder) } },
        singleLine = singleLine,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            backgroundColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.shadow(
            elevation = elevation,
            clip = true,
            shape = RoundedCornerShape(12.dp)
        ),
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun LetsSeePasswordTextField(
    password: String,
    onPasswordChange: (String) -> Unit,
    showPassword: () -> Unit,
    passwordVisible: Boolean
) {
    LetsSeeTextField(
        value = password,
        onValueChange = onPasswordChange,
        placeholder = "Password",
        trailingIcon = {
            IconButton(onClick = showPassword) {
                Icon(
                    imageVector = if (!passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = "Visibility toggle"
                )
            }
        },
        isVisible = passwordVisible
    )
}

@Preview(showBackground = true)
@Composable
fun LetsSeeTextFieldPreview() {
    LetsSeeTextField(
        value = "",
        onValueChange = {},
        placeholder = "Password"
    )
}