package com.example.affirmationsknight.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// Stores the text and image resources for an affirmation.
data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)