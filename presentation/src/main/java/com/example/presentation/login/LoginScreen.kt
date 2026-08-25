package com.example.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.atoms.InvexaButton
import com.example.designsystem.components.atoms.InvexaCheckbox
import com.example.designsystem.components.atoms.InvexaTextButton
import com.example.designsystem.components.atoms.InvexaTextField
import com.example.designsystem.theme.gradients
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.component.ButtonSize
import com.example.designsystem.tokens.raw.Spacing
import com.example.designsystem.tokens.semantic.SemanticShapes
import com.example.presentation.R


@Composable
fun LoginScreen() {
    LazyColumn {
        item {
            CollapsingHeaderScreen()
        }
        item {
            LoginScreenContent()
        }
    }
}

@Composable
fun CollapsingHeaderScreen() {
    val gradients = MaterialTheme.gradients
    val typography = MaterialTheme.typography

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .clip(RoundedCornerShape(bottomStart = SemanticShapes.shapeXL, bottomEnd = SemanticShapes.shapeXL))
            .background(
                brush = Brush.verticalGradient(colors = gradients.primaryHero)
            ),
        contentAlignment = Alignment.BottomStart
    ) {
        Column(
            modifier = Modifier.padding(start = Spacing.space300, Spacing.space800, end = Spacing.space600, bottom = Spacing.space600),
            verticalArrangement = Arrangement.spacedBy(Spacing.space100)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(R.drawable.ic_logo),contentDescription = null, modifier = Modifier.size(48.dp))
                Text(
                    text = "invexa",
                    color = Color.White,
                    style = typography.titleMedium,
                )
            }
            Text(
                text = "Welcome back",
                color = Color.White,
                style = typography.headlineLarge,
                modifier = Modifier.padding(start = Spacing.space300)
            )
            Text(
                text = "Sign in to continue to your account",
                color = Color.White.copy(alpha = 0.8f),
                style = typography.bodySmall,
                modifier = Modifier.padding(start = Spacing.space300)
            )

        }
    }
}

@Composable
fun LoginScreenContent(){
    var fieldValue by remember { mutableStateOf("") }
    var checkboxOn by remember { mutableStateOf(false) }
    val typography = MaterialTheme.typography
    val extend = MaterialTheme.invexaColors

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Spacing.space400, vertical = Spacing.space600),
        verticalArrangement = Arrangement.spacedBy(Spacing.space300)
    ) {
        InvexaTextField(
            value = fieldValue,
            onValueChange = { fieldValue = it },
            label = "Email",
            placeholder = "you@company.com"
        )
        InvexaTextField(
            value = "",
            onValueChange = {},
            label = "Password",
            isPassword = true,
            helperText = "At least 8 characters"
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InvexaCheckbox(
                label = "Remember me",
                checked = checkboxOn,
                onCheckedChange = { checkboxOn = it }
            )
            InvexaTextButton(
                text = "Forget Password?",
                onClick = {}
            )
        }
        InvexaButton(
            onClick = {},
            text = "Login",
            modifier = Modifier.fillMaxWidth(),
            size = ButtonSize.Large,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "New to Invexa?",
                color = extend.textTertiary.copy(alpha = 0.8f),
                style = typography.bodySmall,
            )
            InvexaTextButton(
                text = "Create your company account",
                onClick = {}
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Secured by enterprise-grade security",
                color = extend.textTertiary.copy(alpha = 0.8f),
                style = typography.bodySmall,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}