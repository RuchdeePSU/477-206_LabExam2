package com.example.macbook.labexam2;

/**
 * Created by macbook on 11/19/2017 AD.
 */

public class Member {
    private int _member_id;
    private String _first_name;
    private String _last_name;
    private String _email;
    private String _phone_no;

    public Member(int _member_id, String _first_name, String _last_name, String _email, String _phone_no) {
        this._member_id = _member_id;
        this._first_name = _first_name;
        this._last_name = _last_name;
        this._email = _email;
        this._phone_no = _phone_no;
    }

    public Member(String _first_name, String _last_name, String _email, String _phone_no) {
        this._first_name = _first_name;
        this._last_name = _last_name;
        this._email = _email;
        this._phone_no = _phone_no;
    }

    public int get_member_id() {
        return _member_id;
    }

    public void set_member_id(int _member_id) {
        this._member_id = _member_id;
    }

    public String get_first_name() {
        return _first_name;
    }

    public void set_first_name(String _first_name) {
        this._first_name = _first_name;
    }

    public String get_last_name() {
        return _last_name;
    }

    public void set_last_name(String _last_name) {
        this._last_name = _last_name;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_phone_no() {
        return _phone_no;
    }

    public void set_phone_no(String _phone_no) {
        this._phone_no = _phone_no;
    }
}
