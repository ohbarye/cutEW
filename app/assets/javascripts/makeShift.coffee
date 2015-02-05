$ ->
	# 交代制変更時
	$('input[name=shiftSystem]').change ->
		showShiftDetail($(this).val())
	@	

	# シフト表イメージの各セルクリック時、オンオフを切り替える
	$('td.calendar-cell').click ->
		switchHoliday(this)
	@

	# 行を追加する
	$('.add-member').click ->
		
	@

@

# 交代制詳細部の表示制御
showShiftDetail = (display) ->
	if parseBool(display)
		$('#shiftDetail').show()
	else
		$('#shiftDetail').hide()
		
# シフト表イメージの各セルクリック時、オンオフを切り替える
switchHoliday = (obj) ->	
	if $(obj).text() == ""
		$(obj).text("休")
		$(obj).addClass("holiday")
	else
		$(obj).text("")
		$(obj).removeClass("holiday")

parseBool = (value) ->
	if /^(true|on|yes|1)$/.test(value)
		true
	else if /^(false|off|no|0)$/.test(value)
		false