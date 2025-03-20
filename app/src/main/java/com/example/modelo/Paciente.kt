package com.example.modelo

class Paciente {
    private var _id:String? = ""
    private var _nom:String? = ""
    private var _ape:String? = ""
    private var _tel:Int? = 0
    private var _img:String? = ""

    constructor()

    constructor(_id: String, _nom: String, _ape: String, _tel: Int, _img: String) {
        this._id = _id
        this._nom = _nom
        this._ape = _ape
        this._tel = _tel
        this._img = _img
    }

    var getId:String?
        get() = _id
        set(value) {_id = value}

    var getNom:String?
        get() = _nom
        set(value) {_nom = value}

    var getApe:String?
        get() = _ape
        set(value) {_ape = value}

    var getTel:Int?
        get() = _tel
        set(value) {_tel = value}

    var getImg:String?
        get() = _img
        set(value) {_img = value}
}