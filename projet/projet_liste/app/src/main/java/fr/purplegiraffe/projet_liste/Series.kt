package fr.purplegiraffe.liste

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class Series() : RealmObject()
{
    var name:String = ""
    var show:String = ""

    constructor(name:String, show:String) : this()
    {
        this.name = name
        this.show = show
    }
}

