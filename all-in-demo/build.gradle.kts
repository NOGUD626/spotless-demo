plugins {
    id("com.diffplug.spotless") version "6.25.0"
}

// Spotless が内部で必要とするフォーマッタ jar (google-java-format / ktlint / jackson / dbeaver / flexmark ...) を
// 取りに行く先。これがないと "no repositories are defined" で失敗する。
repositories {
    mavenCentral()
}

// Spotless が公式サポートしているフォーマッタを一通り並べたデモ。
//
// このプロジェクトのソースはコンパイルする目的では作っていない (Java/Kotlin/Groovy
// プラグインをわざと適用していない)。Spotless だけ走らせて、
// 「ブロック単位で別々のフォーマッタを差し込める」ことを見せるための構成。
spotless {
    // ── JVM 系 ───────────────────────────────────────────

    // Java: Google 公式の google-java-format
    java {
        target("src/main/java/**/*.java")
        googleJavaFormat("1.22.0")
        removeUnusedImports()
        importOrder()
    }

    // Kotlin: ktlint
    kotlin {
        target("src/main/kotlin/**/*.kt")
        ktlint("1.3.1")
    }

    // Groovy: greclipse (Eclipse Groovy バンドル)
    groovy {
        target("src/main/groovy/**/*.groovy")
        greclipse()
        importOrder()
    }

    // ── データ / 設定ファイル系 ───────────────────────────

    // JSON: Jackson (pretty print)
    json {
        target("src/main/resources/**/*.json")
        jackson()
    }

    // YAML: Jackson
    yaml {
        target("src/main/resources/**/*.yaml", "src/main/resources/**/*.yml")
        jackson()
    }

    // SQL: DBeaver の SQL フォーマッタ
    sql {
        target("src/sql/**/*.sql")
        dbeaver()
    }

    // ── ドキュメント系 ──────────────────────────────────

    // Markdown: flexmark (Spotless v6.13+ で markdown 専用 extension `flexmark {}` を使う)
    flexmark {
        target("src/**/*.md")
        flexmark("0.64.8")
        trimTrailingWhitespace()
        endWithNewline()
    }

    // XML: 公式の eclipseWtp() は重いので、ここでは汎用ステップだけ
    //     (本格的にやるなら eclipseWtp(XML) を使う)
    format("xml") {
        target("src/main/resources/**/*.xml")
        trimTrailingWhitespace()
        endWithNewline()
        indentWithSpaces(2)
    }

    // Protobuf: buf() は buf バイナリが必要。ここでは汎用ステップだけ。
    format("proto") {
        target("src/main/proto/**/*.proto")
        trimTrailingWhitespace()
        endWithNewline()
    }

    // ── ビルドスクリプト自身も整える ──────────────────────

    kotlinGradle {
        target("*.gradle.kts")
        ktlint("1.3.1")
    }
}
