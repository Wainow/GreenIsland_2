package com.wainow.greenisland.data.api

/**
 * Замоканные результаты акций
 */
object MockedResults {
    /**
     * Получение замоканных стоимостей акций по валюте
     *
     * @param baseValue валюта акции
     *
     * @return JSON акций
     */
    fun getLatestStock(baseValue: String): String {
        return when (baseValue) {
            "USD" ->
                "{\"motd\":{\"msg\":\"If you or your company use this project or like what we doing, please consider backing us so we can continue maintaining and evolving this project.\",\"url\":\"https://exchangerate.host/#/donate\"},\"success\":true,\"base\":\"USD\",\"date\":\"2022-06-02\",\"rates\":{\"AED\":3.669098,\"AFN\":89.353144,\"ALL\":112.924571,\"AMD\":448.190959,\"ANG\":1.800311,\"AOA\":423.59918,\"ARS\":120.175298,\"AUD\":1.396002,\"AWG\":1.799305,\"AZN\":1.698433,\"BAM\":1.833328,\"BBD\":1.997428,\"BDT\":89.472914,\"BGN\":1.833533,\"BHD\":0.377556,\"BIF\":2065.131835,\"BMD\":0.99944,\"BND\":1.370331,\"BOB\":6.875659,\"BRL\":4.811436,\"BSD\":0.999871,\"BTC\":0.000034,\"BTN\":77.417275,\"BWP\":12.052266,\"BYN\":3.373264,\"BZD\":2.013308,\"CAD\":1.266901,\"CDF\":1999.917444,\"CHF\":0.962279,\"CLF\":0.03013,\"CLP\":823.230374,\"CNH\":6.700836,\"CNY\":6.691255,\"COP\":3786.922411,\"CRC\":681.827208,\"CUC\":0.999843,\"CUP\":25.718353,\"CVE\":103.512746,\"CZK\":23.184767,\"DJF\":178.81966,\"DKK\":6.973591,\"DOP\":55.345869,\"DZD\":144.907114,\"EGP\":18.607802,\"ERN\":14.981515,\"ETB\":51.735019,\"EUR\":0.938038,\"FJD\":2.149578,\"FKP\":0.801109,\"GBP\":0.800983,\"GEL\":3.001814,\"GGP\":0.800516,\"GHS\":7.860245,\"GIP\":0.801034,\"GMD\":54.083461,\"GNF\":8885.428391,\"GTQ\":7.674178,\"GYD\":208.921125,\"HKD\":7.837617,\"HNL\":24.685457,\"HRK\":7.061581,\"HTG\":112.500528,\"HUF\":371.849328,\"IDR\":14488.039635,\"ILS\":3.339681,\"IMP\":0.801002,\"INR\":77.514651,\"IQD\":1466.006365,\"IRR\":42347.500687,\"ISK\":128.311444,\"JEP\":0.801064,\"JMD\":154.547172,\"JOD\":0.708807,\"JPY\":129.854363,\"KES\":116.705454,\"KGS\":81.410316,\"KHR\":4080.117952,\"KMF\":461.478317,\"KPW\":898.885877,\"KRW\":1252.443492,\"KWD\":0.305948,\"KYD\":0.832856,\"KZT\":433.173768,\"LAK\":13509.95214,\"LBP\":1518.755851,\"LKR\":361.102576,\"LRD\":151.811423,\"LSL\":15.595856,\"LYD\":4.777684,\"MAD\":9.904043,\"MDL\":19.095078,\"MGA\":4018.795879,\"MKD\":57.746008,\"MMK\":1848.892851,\"MNT\":3101.510539,\"MOP\":8.06984,\"MRU\":36.439449,\"MUR\":43.595863,\"MVR\":15.425841,\"MWK\":815.239733,\"MXN\":19.693271,\"MYR\":4.386941,\"MZN\":63.796584,\"NAD\":15.541035,\"NGN\":414.636814,\"NIO\":36.010336,\"NOK\":9.491407,\"NPR\":123.867953,\"NZD\":1.544051,\"OMR\":0.384959,\"PAB\":0.999242,\"PEN\":3.732846,\"PGK\":3.544839,\"PHP\":52.470918,\"PKR\":198.633112,\"PLN\":4.301766,\"PYG\":6876.787227,\"QAR\":3.636828,\"RON\":4.629041,\"RSD\":110.069314,\"RUB\":61.948576,\"RWF\":1024.715257,\"SAR\":3.746262,\"SBD\":8.107193,\"SCR\":13.350302,\"SDG\":454.436899,\"SEK\":9.832906,\"SGD\":1.376327,\"SHP\":0.800654,\"SLL\":12871.243528,\"SOS\":581.067489,\"SRD\":21.096382,\"SSP\":130.099616,\"STD\":22965.529656,\"STN\":23.346682,\"SVC\":8.738017,\"SYP\":2509.418663,\"SZL\":15.596203,\"THB\":34.361887,\"TJS\":12.426695,\"TMT\":3.496265,\"TND\":3.033075,\"TOP\":2.304278,\"TRY\":16.414317,\"TTD\":6.773178,\"TWD\":29.361496,\"TZS\":2326.116436,\"UAH\":29.482786,\"UGX\":3816.904604,\"USD\":1,\"UYU\":39.869496,\"UZS\":11028.935594,\"VES\":5.052897,\"VND\":23178.507876,\"VUV\":114.487735,\"WST\":2.610597,\"XAF\":614.774257,\"XAG\":0.046153,\"XAU\":0.001855,\"XCD\":2.699782,\"XDR\":0.725222,\"XOF\":614.774254,\"XPD\":0.001427,\"XPF\":111.840328,\"XPT\":0.001555,\"YER\":249.940203,\"ZAR\":15.596516,\"ZMW\":17.251078,\"ZWL\":321.601702}}"
            "RUB" ->
                "{\"motd\":{\"msg\":\"If you or your company use this project or like what we doing, please consider backing us so we can continue maintaining and evolving this project.\",\"url\":\"https://exchangerate.host/#/donate\"},\"success\":true,\"base\":\"RUB\",\"date\":\"2022-06-02\",\"rates\":{\"AED\":0.059228,\"AFN\":1.442376,\"ALL\":1.822876,\"AMD\":7.234887,\"ANG\":0.029061,\"AOA\":6.837916,\"ARS\":1.93992,\"AUD\":0.022535,\"AWG\":0.029045,\"AZN\":0.027417,\"BAM\":0.029594,\"BBD\":0.032243,\"BDT\":1.444309,\"BGN\":0.029598,\"BHD\":0.006095,\"BIF\":33.336228,\"BMD\":0.016133,\"BND\":0.02212,\"BOB\":0.11099,\"BRL\":0.077668,\"BSD\":0.01614,\"BTC\":0.000001,\"BTN\":1.249702,\"BWP\":0.194553,\"BYN\":0.054453,\"BZD\":0.0325,\"CAD\":0.020451,\"CDF\":32.28351,\"CHF\":0.015534,\"CLF\":0.000486,\"CLP\":13.288931,\"CNH\":0.108168,\"CNY\":0.108013,\"COP\":61.130096,\"CRC\":11.006342,\"CUC\":0.01614,\"CUP\":0.415156,\"CVE\":1.670946,\"CZK\":0.374258,\"DJF\":2.886582,\"DKK\":0.112571,\"DOP\":0.893416,\"DZD\":2.339152,\"EGP\":0.300375,\"ERN\":0.241838,\"ETB\":0.835128,\"EUR\":0.015142,\"FJD\":0.034699,\"FKP\":0.012932,\"GBP\":0.01293,\"GEL\":0.048457,\"GGP\":0.012922,\"GHS\":0.126883,\"GIP\":0.012931,\"GMD\":0.873038,\"GNF\":143.432327,\"GTQ\":0.12388,\"GYD\":3.372493,\"HKD\":0.126518,\"HNL\":0.398483,\"HRK\":0.113991,\"HTG\":1.816031,\"HUF\":6.002548,\"IDR\":233.872037,\"ILS\":0.053911,\"IMP\":0.01293,\"INR\":1.251274,\"IQD\":23.664892,\"IRR\":683.59119,\"ISK\":2.071257,\"JEP\":0.012931,\"JMD\":2.494766,\"JOD\":0.011442,\"JPY\":2.096164,\"KES\":1.883909,\"KGS\":1.31416,\"KHR\":65.862982,\"KMF\":7.449377,\"KPW\":14.510194,\"KRW\":20.21747,\"KWD\":0.004939,\"KYD\":0.013444,\"KZT\":6.992473,\"LAK\":218.083337,\"LBP\":24.516397,\"LKR\":5.82907,\"LRD\":2.450604,\"LSL\":0.251755,\"LYD\":0.077123,\"MAD\":0.159875,\"MDL\":0.308241,\"MGA\":64.873096,\"MKD\":0.93216,\"MMK\":29.845607,\"MNT\":50.065889,\"MOP\":0.130267,\"MRU\":0.588221,\"MUR\":0.703743,\"MVR\":0.24901,\"MWK\":13.159943,\"MXN\":0.317897,\"MYR\":0.070816,\"MZN\":1.029831,\"NAD\":0.25087,\"NGN\":6.693242,\"NIO\":0.581294,\"NOK\":0.153214,\"NPR\":1.999529,\"NZD\":0.024925,\"OMR\":0.006214,\"PAB\":0.01613,\"PEN\":0.060257,\"PGK\":0.057222,\"PHP\":0.847008,\"PKR\":3.206419,\"PLN\":0.069441,\"PYG\":111.007995,\"QAR\":0.058707,\"RON\":0.074724,\"RSD\":1.776785,\"RUB\":1,\"RWF\":16.541385,\"SAR\":0.060474,\"SBD\":0.13087,\"SCR\":0.215506,\"SDG\":7.335712,\"SEK\":0.158727,\"SGD\":0.022217,\"SHP\":0.012924,\"SLL\":207.773034,\"SOS\":9.379836,\"SRD\":0.340547,\"SSP\":2.100123,\"STD\":370.719251,\"STN\":0.376872,\"SVC\":0.141053,\"SYP\":40.508093,\"SZL\":0.25176,\"THB\":0.554684,\"TJS\":0.200597,\"TMT\":0.056438,\"TND\":0.048961,\"TOP\":0.037197,\"TRY\":0.264967,\"TTD\":0.109335,\"TWD\":0.473966,\"TZS\":37.549151,\"UAH\":0.475924,\"UGX\":61.614082,\"USD\":0.016142,\"UYU\":0.64359,\"UZS\":178.033723,\"VES\":0.081566,\"VND\":374.157235,\"VUV\":1.848109,\"WST\":0.042141,\"XAF\":9.923945,\"XAG\":0.000745,\"XAU\":0.00003,\"XCD\":0.043581,\"XDR\":0.011707,\"XOF\":9.923945,\"XPD\":0.000023,\"XPF\":1.805374,\"XPT\":0.000025,\"YER\":4.03464,\"ZAR\":0.251766,\"ZMW\":0.278474,\"ZWL\":5.19143}}"
            "CZK" ->
                "{\"motd\":{\"msg\":\"If you or your company use this project or like what we doing, please consider backing us so we can continue maintaining and evolving this project.\",\"url\":\"https://exchangerate.host/#/donate\"},\"success\":true,\"base\":\"CZK\",\"date\":\"2022-06-02\",\"rates\":{\"AED\":0.158316,\"AFN\":3.855211,\"ALL\":4.854905,\"AMD\":19.224453,\"ANG\":0.077699,\"AOA\":18.276528,\"ARS\":5.184989,\"AUD\":0.060048,\"AWG\":0.07762,\"AZN\":0.073266,\"BAM\":0.07866,\"BBD\":0.086235,\"BDT\":3.837832,\"BGN\":0.079147,\"BHD\":0.016277,\"BIF\":88.088215,\"BMD\":0.043112,\"BND\":0.059123,\"BOB\":0.296658,\"BRL\":0.207583,\"BSD\":0.043134,\"BTC\":0.000001,\"BTN\":3.340253,\"BWP\":0.516912,\"BYN\":0.145525,\"BZD\":0.086877,\"CAD\":0.054612,\"CDF\":86.288029,\"CHF\":0.041491,\"CLF\":0.001321,\"CLP\":35.491301,\"CNH\":0.288859,\"CNY\":0.288132,\"COP\":163.37438,\"CRC\":29.021091,\"CUC\":0.043123,\"CUP\":1.10965,\"CVE\":4.466105,\"CZK\":1,\"DJF\":7.665919,\"DKK\":0.300777,\"DOP\":2.375043,\"DZD\":6.252956,\"EGP\":0.802639,\"ERN\":0.646428,\"ETB\":2.232115,\"EUR\":0.040441,\"FJD\":0.092661,\"FKP\":0.034525,\"GBP\":0.034501,\"GEL\":0.129535,\"GGP\":0.034501,\"GHS\":0.336773,\"GIP\":0.034523,\"GMD\":2.33349,\"GNF\":381.095305,\"GTQ\":0.331164,\"GYD\":9.014061,\"HKD\":0.338189,\"HNL\":1.058122,\"HRK\":0.304678,\"HTG\":4.82552,\"HUF\":16.035495,\"IDR\":627.261188,\"ILS\":0.144073,\"IMP\":0.034496,\"INR\":3.34209,\"IQD\":62.901664,\"IRR\":1827.11658,\"ISK\":5.535245,\"JEP\":0.034511,\"JMD\":6.629083,\"JOD\":0.030595,\"JPY\":5.600522,\"KES\":5.035387,\"KGS\":3.512487,\"KHR\":175.030686,\"KMF\":19.910841,\"KPW\":38.783125,\"KRW\":53.775743,\"KWD\":0.013208,\"KYD\":0.035937,\"KZT\":18.580425,\"LAK\":579.51602,\"LBP\":65.334907,\"LKR\":15.489092,\"LRD\":6.550049,\"LSL\":0.669757,\"LYD\":0.205074,\"MAD\":0.425155,\"MDL\":0.818161,\"MGA\":173.39415,\"MKD\":2.47695,\"MMK\":79.771954,\"MNT\":133.817143,\"MOP\":0.3482,\"MRU\":1.572233,\"MUR\":1.870199,\"MVR\":0.665576,\"MWK\":35.174186,\"MXN\":0.848973,\"MYR\":0.189208,\"MZN\":2.752542,\"NAD\":0.670527,\"NGN\":17.889813,\"NIO\":1.544313,\"NOK\":0.409529,\"NPR\":5.344367,\"NZD\":0.066458,\"OMR\":0.016589,\"PAB\":0.04313,\"PEN\":0.160093,\"PGK\":0.152976,\"PHP\":2.262911,\"PKR\":8.520053,\"PLN\":0.185495,\"PYG\":296.70442,\"QAR\":0.156939,\"RON\":0.199792,\"RSD\":4.747976,\"RUB\":2.736424,\"RWF\":44.074421,\"SAR\":0.161635,\"SBD\":0.3498,\"SCR\":0.585174,\"SDG\":19.607058,\"SEK\":0.424075,\"SGD\":0.059262,\"SHP\":0.034507,\"SLL\":555.340053,\"SOS\":25.003537,\"SRD\":0.910203,\"SSP\":5.613242,\"STD\":990.866028,\"STN\":1.007302,\"SVC\":0.377046,\"SYP\":108.270877,\"SZL\":0.669591,\"THB\":1.480593,\"TJS\":0.536161,\"TMT\":0.15082,\"TND\":0.130845,\"TOP\":0.099315,\"TRY\":0.708297,\"TTD\":0.2922,\"TWD\":1.259689,\"TZS\":100.362183,\"UAH\":1.272056,\"UGX\":163.722718,\"USD\":0.043134,\"UYU\":1.720216,\"UZS\":473.280326,\"VES\":0.218009,\"VND\":999.804598,\"VUV\":4.93967,\"WST\":0.112634,\"XAF\":26.520775,\"XAG\":0.002008,\"XAU\":0.000053,\"XCD\":0.116459,\"XDR\":0.03129,\"XOF\":26.52078,\"XPD\":0.00007,\"XPF\":4.824702,\"XPT\":0.000076,\"YER\":10.783881,\"ZAR\":0.671868,\"ZMW\":0.744297,\"ZWL\":13.875774}}"

            else -> "{\"motd\":{\"msg\":\"If you or your company use this project or like what we doing, please consider backing us so we can continue maintaining and evolving this project.\",\"url\":\"https://exchangerate.host/#/donate\"},\"success\":true,\"base\":\"EUR\",\"date\":\"2022-06-02\",\"rates\":{\"AED\":3.911461,\"AFN\":95.255378,\"ALL\":120.383819,\"AMD\":477.796273,\"ANG\":1.919231,\"AOA\":451.580081,\"ARS\":128.113494,\"AUD\":1.488215,\"AWG\":1.918159,\"AZN\":1.810623,\"BAM\":1.954429,\"BBD\":2.129369,\"BDT\":95.383059,\"BGN\":1.954648,\"BHD\":0.402495,\"BIF\":2201.544399,\"BMD\":1.065459,\"BND\":1.460848,\"BOB\":7.329831,\"BRL\":5.129256,\"BSD\":1.065917,\"BTC\":0.000036,\"BTN\":82.531084,\"BWP\":12.84838,\"BYN\":3.596086,\"BZD\":2.146298,\"CAD\":1.350586,\"CDF\":2132.022262,\"CHF\":1.025842,\"CLF\":0.03212,\"CLP\":877.608968,\"CNH\":7.14346,\"CNY\":7.133246,\"COP\":4037.068084,\"CRC\":726.865397,\"CUC\":1.065888,\"CUP\":27.417183,\"CVE\":110.350294,\"CZK\":24.71624,\"DJF\":190.631617,\"DKK\":7.434233,\"DOP\":59.001747,\"DZD\":154.478973,\"EGP\":19.836943,\"ERN\":15.971121,\"ETB\":55.152383,\"EUR\":1,\"FJD\":2.291569,\"FKP\":0.854027,\"GBP\":0.853892,\"GEL\":3.2001,\"GGP\":0.853394,\"GHS\":8.379455,\"GIP\":0.853947,\"GMD\":57.655951,\"GNF\":9472.35657,\"GTQ\":8.181096,\"GYD\":222.721438,\"HKD\":8.355332,\"HNL\":26.316058,\"HRK\":7.528034,\"HTG\":119.931766,\"HUF\":396.411886,\"IDR\":15445.049059,\"ILS\":3.560284,\"IMP\":0.853912,\"INR\":82.634892,\"IQD\":1562.843614,\"IRR\":45144.770592,\"ISK\":136.787074,\"JEP\":0.853978,\"JMD\":164.755806,\"JOD\":0.755627,\"JPY\":138.431911,\"KES\":124.414449,\"KGS\":86.787886,\"KHR\":4349.630697,\"KMF\":491.96133,\"KPW\":958.261906,\"KRW\":1335.173817,\"KWD\":0.326157,\"KYD\":0.88787,\"KZT\":461.78712,\"LAK\":14402.353862,\"LBP\":1619.077475,\"LKR\":384.955255,\"LRD\":161.839347,\"LSL\":16.626043,\"LYD\":5.093274,\"MAD\":10.558256,\"MDL\":20.356406,\"MGA\":4284.257986,\"MKD\":61.560428,\"MMK\":1971.021719,\"MNT\":3306.381239,\"MOP\":8.602894,\"MRU\":38.846461,\"MUR\":46.475593,\"MVR\":16.444797,\"MWK\":869.090505,\"MXN\":20.994112,\"MYR\":4.676721,\"MZN\":68.010676,\"NAD\":16.5676,\"NGN\":442.025704,\"NIO\":38.389003,\"NOK\":10.118363,\"NPR\":132.050067,\"NZD\":1.646043,\"OMR\":0.410388,\"PAB\":1.065247,\"PEN\":3.97942,\"PGK\":3.778994,\"PHP\":55.936891,\"PKR\":211.75385,\"PLN\":4.58592,\"PYG\":7331.034341,\"QAR\":3.87706,\"RON\":4.934813,\"RSD\":117.339957,\"RUB\":66.040597,\"RWF\":1092.402962,\"SAR\":3.993721,\"SBD\":8.642715,\"SCR\":14.232158,\"SDG\":484.45479,\"SEK\":10.48242,\"SGD\":1.467241,\"SHP\":0.853541,\"SLL\":13721.455266,\"SOS\":619.449981,\"SRD\":22.489907,\"SSP\":138.693364,\"STD\":24482.520834,\"STN\":24.88885,\"SVC\":9.315208,\"SYP\":2675.178653,\"SZL\":16.626412,\"THB\":36.631666,\"TJS\":13.247542,\"TMT\":3.727211,\"TND\":3.233426,\"TOP\":2.456487,\"TRY\":17.498567,\"TTD\":7.220581,\"TWD\":31.300973,\"TZS\":2479.768373,\"UAH\":31.430275,\"UGX\":4069.030755,\"USD\":1.066055,\"UYU\":42.503081,\"UZS\":11757.453432,\"VES\":5.386667,\"VND\":24709.567359,\"VUV\":122.050238,\"WST\":2.78304,\"XAF\":655.383254,\"XAG\":0.049202,\"XAU\":0.001977,\"XCD\":2.878117,\"XDR\":0.773127,\"XOF\":655.383251,\"XPD\":0.001522,\"XPF\":119.227956,\"XPT\":0.001658,\"YER\":266.450037,\"ZAR\":16.626746,\"ZMW\":18.3906,\"ZWL\":342.845146}}"
        }
    }
}