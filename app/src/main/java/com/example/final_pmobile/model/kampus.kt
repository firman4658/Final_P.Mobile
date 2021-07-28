package com.example.final_pmobile.model

class kampus {
    private var title: String = ""
    private var descripton: String =""

    constructor(title: String, description: String){
        this.title = title
        this.descripton = description
    }
    fun getTitle(): String{
        return title
    }

    fun setTitle(title: String){
        this.title = title
    }

    fun getDescription(): String{
        return descripton
    }

    fun setDescription(description: String){
        this.descripton = description
    }
}