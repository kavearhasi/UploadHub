package com.example.uploadhub.data.di

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.storage.Storage


class SupabaseManager {

    companion object {
        val CLIENT = createSupabaseClient(
            supabaseUrl = "https://ikaefqanqomqcrsexytp.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImlrYWVmcWFucW9tcWNyc2V4eXRwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDE5MzA3MjgsImV4cCI6MjA1NzUwNjcyOH0.GQERjMwTU6IgyHf0OeHsGnJqE-N2zp9rXmehQgr5taA"
        ) {
            install(Storage)
        }
    }

}