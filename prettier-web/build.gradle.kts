plugins {
    id("com.diffplug.spotless") version "6.25.0"
}

// Spotless が内部で必要とするフォーマッタ jar を取りに行く先
repositories {
    mavenCentral()
}

// Prettier 中心 (Web 系) のサンプル
// JS / TS / CSS / HTML / Markdown / JSON / YAML を全部 Prettier に投げる
//
// 注意: Spotless の Prettier ステップは Node.js が必要。
//       初回実行時に Spotless が自動で node_modules をキャッシュディレクトリに展開する。
spotless {
    // 1) Web 系ファイルを Prettier で一括処理
    //    parser はファイル拡張子から Prettier が自動推定する。
    format("web") {
        target(
            "src/**/*.js",
            "src/**/*.jsx",
            "src/**/*.ts",
            "src/**/*.tsx",
            "src/**/*.css",
            "src/**/*.scss",
            "src/**/*.html",
            "src/**/*.md",
        )
        prettier("3.3.3")
    }

    // 2) JSON は専用ブロックでも書ける (中身は同じ Prettier)
    json {
        target("src/**/*.json")
        prettier("3.3.3")
    }

    // 3) YAML も専用ブロック
    yaml {
        target("src/**/*.yaml", "src/**/*.yml")
        prettier("3.3.3")
    }

    // 4) 汎用 (.gitignore / ルート直下の README) は行末スペース削除と末尾改行だけ
    format("misc") {
        target(".gitignore", "README.md")
        trimTrailingWhitespace()
        endWithNewline()
    }

    // 5) build.gradle.kts 自体も Spotless で揃える (ktlint)
    kotlinGradle {
        target("*.gradle.kts")
        ktlint("1.3.1")
    }
}
