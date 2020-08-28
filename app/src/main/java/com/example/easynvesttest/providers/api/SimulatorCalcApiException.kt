package com.example.easynvesttest.providers.api

import java.io.IOException

class EasyApiException(val httpStatus: Int) : IOException()